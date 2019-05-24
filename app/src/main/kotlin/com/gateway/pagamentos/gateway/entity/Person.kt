package com.gateway.pagamentos.gateway.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import io.swagger.models.auth.In
import javax.persistence.*;
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "person")
@ApiModel(description = "Class representing a person entity that makes payments")
class Person(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int,

    @field:NotEmpty
    @Column(name = "name")
    @ApiModelProperty(notes = "Name of person", example = "John Mabell Rynyone", required = true)
    val name: String?,

    @field:Email
    @ApiModelProperty(notes = "Email of person", example = "sample@mail.com", allowEmptyValue = true)
    val email: String? = "",

    @field:NotEmpty
    @Column(name = "address_line_1")
    @ApiModelProperty(notes = "Principals datas of address, in this field must be informed: Number, Street, Neighborhood.", example = "728, John Colin, Center", required = true)
    val addressLine1: String?,

    @Column(name = "address_line_2")
    @ApiModelProperty(notes = "Complement data of address", example = "Ap. 306, block E", allowEmptyValue = true)
    val addressLine2: String? = "",

    @field:NotNull
    @Column(name = "zip_code")
    @ApiModelProperty(notes = "Zip code of address", example = "39674207", required = true)
    val zipCode: String?,

    @field:NotEmpty
    @Column(name = "city")
    @ApiModelProperty(notes = "City of address", example = "Joinville", required = true)
    val city: String?,

    @field:[NotEmpty Size(min=2, max = 2)]
    @Column(name = "state")
    @ApiModelProperty(notes = "Code of State in format ISO 3166-2, more info about ISO 3166-2 in http://twixar.me/VSWn", example = "SC", required = true)
    val state: String?,

    @field:[NotEmpty Size(min=2, max = 2)]
    @Column(name = "country")
    @ApiModelProperty(notes = "Code of Country in format ISO 3166-1 alpha-2, more info about 3166-1 alpha-2 in http://twixar.me/ZXWn", example = "BR", required = true)
    val country: String?,

    @field:NotNull
    @Column(name = "document_type")
    @ApiModelProperty(notes = "Document type: 1 (CPF); 2 (CNPJ)", example = "2", required = true)
    val documentType: Int?,

    @field:NotEmpty
    @Column(name = "document")
    @ApiModelProperty(notes = "Document, this field depends of value the document_type field", example = "98765432109", required = true)
    val document: String?,

    @field:NotNull
    @Column(name = "phone_country_code")
    @ApiModelProperty(notes = "Country code", example = "55", required = true)
    val phoneCountryCode: Int?,

    @field:NotEmpty
    @Column(name = "phone_number")
    @ApiModelProperty(notes = "Number", example = "000000000", required = true)
    val phoneNumber: String?,

    @field:NotNull
    @Column(name = "phone_area_code")
    @ApiModelProperty(notes = "Area code", example = "47", required = true)
    val phoneAreaCode: Int?
)