package com.jsancue.kafka_cero_a_experto.user.application.emailUpdated;

import com.jsancue.kafka_cero_a_experto.common.application.Command;
import com.jsancue.kafka_cero_a_experto.common.application.VoidResponse;
import com.jsancue.kafka_cero_a_experto.user.domain.entity.Role;
import lombok.Data;

import java.time.Instant;

@Data
public class UserEmailUpdatedCommand implements Command<VoidResponse> {

    private Long id;
    private String email;
    private Instant timestamp;

}
