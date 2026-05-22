package com.jsancue.kafka_cero_a_experto.user.domain.port;

import com.jsancue.kafka_cero_a_experto.user.domain.event.UserDeactivatedDomainEvent;
import com.jsancue.kafka_cero_a_experto.user.domain.event.UserVerificationRequestedDomainEvent;

public interface UserEvent {

    void sendUserDeactivatedDomainEvent(UserDeactivatedDomainEvent event);

    void sendUserVerificationRequestedDomainEvent(UserVerificationRequestedDomainEvent event);

}
