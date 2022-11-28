package com.kefas.blogapplicationweeknine.model.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties(
        value = {"createdBy", "UpdatedBy"},
        allowGetters = true)
public class UserBaseClass extends BaseClass{

    @CreatedBy
    @Column(updatable = false)
    private Long createdBy;

    @LastModifiedBy
    private Long updatedBy;

    public UserBaseClass(Long id, LocalDateTime createdDate, LocalDateTime updateDate, Long createdBy, Long updatedBy) {
        super(id, createdDate, updateDate);
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}
