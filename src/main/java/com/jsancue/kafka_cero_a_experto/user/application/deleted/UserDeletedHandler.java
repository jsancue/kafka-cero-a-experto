package com.jsancue.kafka_cero_a_experto.user.application.deleted;

import com.jsancue.kafka_cero_a_experto.common.application.CommandHandler;
import com.jsancue.kafka_cero_a_experto.common.application.VoidResponse;
import com.jsancue.kafka_cero_a_experto.user.domain.entity.User;
import com.jsancue.kafka_cero_a_experto.user.domain.event.UserDeactivatedDomainEvent;
import com.jsancue.kafka_cero_a_experto.user.domain.port.UserEvent;
import com.jsancue.kafka_cero_a_experto.user.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserDeletedHandler implements CommandHandler<UserDeletedCommand, VoidResponse> {

    private final UserRepository userRepository;

    private final UserEvent userEvent;

    @Override
    public VoidResponse handle(UserDeletedCommand command) {
        log.info("UserDeletedHandler command= {}", command);

        userRepository.findById(command.getId()).ifPresent(user -> {
            log.debug("User deleted: {}", user);
            user.setDeletedAt(command.getTimestamp());
            userRepository.save(user);

            UserDeactivatedDomainEvent domainEvent = UserDeactivatedDomainEvent.of(user);

            userEvent.sendUserDeactivatedDomainEvent(domainEvent);
        });





        return new VoidResponse();
    }

    @Override
    public Class<UserDeletedCommand> getCommandType() {
        return UserDeletedCommand.class;
    }
}
