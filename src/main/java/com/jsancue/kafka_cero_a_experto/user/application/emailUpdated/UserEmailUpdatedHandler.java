package com.jsancue.kafka_cero_a_experto.user.application.emailUpdated;

import com.jsancue.kafka_cero_a_experto.common.application.CommandHandler;
import com.jsancue.kafka_cero_a_experto.common.application.VoidResponse;
import com.jsancue.kafka_cero_a_experto.user.domain.entity.User;
import com.jsancue.kafka_cero_a_experto.user.domain.event.UserVerificationRequestedDomainEvent;
import com.jsancue.kafka_cero_a_experto.user.domain.port.UserEvent;
import com.jsancue.kafka_cero_a_experto.user.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserEmailUpdatedHandler implements CommandHandler<UserEmailUpdatedCommand, VoidResponse> {

    private final UserRepository userRepository;

    private final UserEvent userEvent;

    @Override
    public VoidResponse handle(UserEmailUpdatedCommand command) {
        log.info("UserEmailUpdatedHandler command= {}", command);

        userRepository.findById(command.getId()).ifPresent(user -> {
            user.setEmail(command.getEmail());
            user.setUpdatedAt(command.getTimestamp());
            log.debug("User email updated for user: {}", user);
            userRepository.save(user);

            UserVerificationRequestedDomainEvent domainEvent = UserVerificationRequestedDomainEvent.of(user);
            userEvent.sendUserVerificationRequestedDomainEvent(domainEvent);
        });

        return new VoidResponse();
    }

    @Override
    public Class<UserEmailUpdatedCommand> getCommandType() {
        return UserEmailUpdatedCommand.class;
    }
}
