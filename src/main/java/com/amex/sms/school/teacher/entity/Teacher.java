package com.amex.sms.school.teacher.entity;

import com.amex.sms.school.validators.AmexEmail;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tid")
    @Schema(name= "id",  description = "ID of the Teacher which is unique", example = "0")
    private int id;


    @Column(name="subject")
    private String subject;


    @Column(name="fname")
    @NotBlank(message = "Teacher Firstname is required")
    @Schema(name ="first name", description = "Full name of the Teacher with max of 255 characters", example = "sateesh gullipalli")
    private String fname;


    @Column(name="mname")
    @Schema(name ="middle name", description = "Full name of the Teacher with max of 255 characters", example = "sateesh gullipalli")
    private String mname;

    @Column(name="lname")
    @NotBlank(message = "Teacher Lastname is required")
    @Schema(name ="last name", description = "Full name of the Teacher with max of 255 characters", example = "sateesh gullipalli")
    private String lname;

    @Column(name="email")
    @Email(message = "Email format is not valid")
    //@AmexEmail(message = "Email id should end with @axp.com" )
    @Schema(name = "email", description = "Email id of the Teacher with max of 255 characters and should end with @aexp.com", example = "sateesh.gullipalli@aexp.com")
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


    @Transient
    @NotBlank(message = "DOB shouldn't be blank")
    private String dobStr;
    @Transient
    @NotBlank(message = "DOJ shouldn't be blank")
    private String dojStr;

}
