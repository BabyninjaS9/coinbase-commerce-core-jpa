/*
 * Copyright (c) 2018. DataVolo, Inc.
 */

package com.datavolo.util;

import java.util.Comparator;
import java.util.Date;

/**
 *
 */
public abstract class CompareUtil {

    public static final Comparator<String> StringNaturalNullsLast = Comparator.nullsLast(Comparator.naturalOrder());

    public static final Comparator<Date> DateNaturalNullsLast = Comparator.nullsLast(Comparator.naturalOrder());

    public static final Comparator<Long> LongNaturalNullsLast = Comparator.nullsLast(Comparator.naturalOrder());

}
