/*
 * Copyright (c) 2018. DataVolo, Inc.
 */

package com.tokenopoly.coinbridge.coinbase.commerce.model;

import com.google.common.collect.ComparisonChain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.tokenopoly.util.CompareUtils;

import java.io.Serializable;
import java.util.Comparator;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

@Embeddable
public class PaymentPK implements PaymentIdentifier, Comparable<PaymentIdentifier>, Serializable {

    private static final long serialVersionUID = 6917567371063229215L;

    public static final Comparator<PaymentPK>
        PaymentPKNaturalNullsLast =
        Comparator.nullsLast(Comparator.naturalOrder());

    private String network;
    private String transactionId;

    @SuppressWarnings("unused")
    public static PaymentPK newPaymentId(PaymentIdentifier payment) {
        return new PaymentPK(payment.getNetwork(), payment.getTransactionId());
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public int compareTo(PaymentIdentifier o) {
        return ComparisonChain.start()
            .compare(this.network, o.getNetwork(), CompareUtils.StringNaturalNullsLast)
            .compare(this.transactionId, o.getTransactionId(), CompareUtils.StringNaturalNullsLast)
            .result();
    }
}