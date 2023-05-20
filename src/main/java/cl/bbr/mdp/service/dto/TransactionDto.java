package cl.bbr.mdp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Miguel Angel
 * @since v1.0.0
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private String commerce;
    private Integer amount;
    private String type;
    private String user;
    private String createdAt;

}
