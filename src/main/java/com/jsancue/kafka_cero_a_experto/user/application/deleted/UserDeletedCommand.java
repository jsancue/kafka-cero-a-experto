package com.jsancue.kafka_cero_a_experto.user.application.deleted;

import com.jsancue.kafka_cero_a_experto.common.application.Command;
import com.jsancue.kafka_cero_a_experto.common.application.VoidResponse;
import com.jsancue.kafka_cero_a_experto.user.domain.entity.Role;
import lombok.Data;

import java.time.Instant;

@Data
public class UserDeletedCommand implements Command<VoidResponse> {

    private Long id;
    private Instant timestamp;

}
