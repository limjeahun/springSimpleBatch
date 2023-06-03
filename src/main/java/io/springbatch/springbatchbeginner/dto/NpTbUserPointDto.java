package io.springbatch.springbatchbeginner.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NpTbUserPointDto {
        private Integer         pointIdx;
        private Integer         userIdx;
        private Integer         usePointIdx;
        private Integer         cancelPointIdx;
        private String          trxId;
        private String          pointNm;
        private Integer         point;
        private String          ruleIdx;
        private String          pointDivisionCd;
        private String          pointStatusCd;
        private Date            pointStartDate;
        private Date            pointEndDate;
        private LocalDateTime   regDate;
        private String          regId;

        public NpTbUserPointDto(int pointIdx, int point){
                this.pointIdx        = pointIdx;
                this.point           = point;
        }

}
