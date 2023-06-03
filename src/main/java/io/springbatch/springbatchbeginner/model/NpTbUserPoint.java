package io.springbatch.springbatchbeginner.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "NP_TB_USER_POINT")
public class NpTbUserPoint {
        @Id
        @Column(name = "pointIdx")
        private Integer         pointIdx; //pointIdx
        private Integer         userIdx;
        private Integer         usePointIdx;
        private Integer         cancelPointIdx;
        private String          trxId;
        private String          pointNm;
        private Integer         point;
        private String          ruleIdx;
        private String          pointDivisionCd;
        private String          pointStatusCd;
        @CreationTimestamp
        private Date            pointStartDate;
        @CreationTimestamp
        private Date            pointEndDate;
        @CreationTimestamp
        private LocalDateTime   regDate;
        private String          regId;

}
