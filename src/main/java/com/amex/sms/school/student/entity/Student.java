package com.amex.sms.school.student.entity;

import com.amex.sms.school.config.StudentSerializer;
import com.amex.sms.school.validators.AmexEmail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "student")
@Schema (description = "All details about the student")

@JsonSerialize(using = StudentSerializer.class)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sid")
    @Schema(name= "id",  description = "ID of the student which is unique", example = "0")
    private int id;

    @Column(name="fname")
    @NotBlank(message = "Student Firstname is required")
    @Schema(name ="first name", description = "Full name of the student with max of 255 characters", example = "sateesh gullipalli")
    private String fname;


    @Column(name="mname")
    @Schema(name ="middle name", description = "Full name of the student with max of 255 characters", example = "sateesh gullipalli")
    private String mname;

    @Column(name="lname")
    @NotBlank(message = "Student Lastname is required")
    @Schema(name ="last name", description = "Full name of the student with max of 255 characters", example = "sateesh gullipalli")
    private String lname;

    @Column(name="email")
    @Email(message = "Email format is not valid")
    @AmexEmail(message = "Email id should end with @axp.com" )
    @Schema(name = "email", description = "Email id of the student with max of 255 characters and should end with @aexp.com", example = "sateesh.gullipalli@aexp.com")
    private String email;

    @Transient
    private List<String> fields;

    @Column(name="dob")
    private Date dob;

    @Column(name="doj")
    private Date doj;

    @Min(message= "Minimum grade should be >1", value=1)
    @Max(message= "Maximum grade should be 10", value=10)
    @Column(name="grade")
    private Integer grade;

    @Column(name="phone")
    private String phone;

}
