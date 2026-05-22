package com.jsancue.kafka_cero_a_experto.common.infrastructure.event.util;

import org.mapstruct.Mapper;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper
public interface MapperUtils {

    default Instant epochMiliToInstant(Long milis){
        return milis != null ? Instant.ofEpochMilli(milis) : null;
    }

    default String charSequenceToString(CharSequence sequence) {
        return sequence != null ? sequence.toString() : null;
    }

    default CharSequence stringToCharSequence(String sequence) {
        return sequence;
    }

    default OffsetDateTime fromEpochMilli(Long epochMillis) {
        return epochMillis != null ? Instant.ofEpochMilli(epochMillis).atOffset(ZoneOffset.UTC) : null;
    }
}
