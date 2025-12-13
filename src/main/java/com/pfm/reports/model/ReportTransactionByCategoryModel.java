package com.pfm.reports.model;

import com.pfm.core.model.ClassifierModel;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ReportTransactionByCategoryModel {
    private BigDecimal amount;
    private ClassifierModel categoryCla;
    private String description;
    private ClassifierModel typeCla;
}
