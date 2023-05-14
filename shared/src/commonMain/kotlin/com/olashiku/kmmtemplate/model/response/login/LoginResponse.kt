package com.olashiku.kmmtemplate.model.response.login

@kotlinx.serialization.Serializable
data class LoginResponse(
    val SCARequired: String = "",
    val authorization: String= "",
    val countrycode: String= "",
    val customerid: String= "",
    val customername: String= "",
    val customersupportnumber: String= "",
    val duration: String= "",
    val email: String= "",
    val expirydate: String= "",
    val firstname: String= "",
    val fundtransferfee: String= "",
    val israted: String= "",
    val issuedate: String= "",
    val kycactionurl: String= "",
    val kyclabelmessage: String= "",
    val kycstatus: String= "",
    val kyctier: String= "",
    val lastlogin: String= "",
    val lastname: String= "",
    val mobilenumber: String= "",
    val popmessage: String= "",
    val profileimage: String= "",
    val profilestatusupdate: String= "",
    val referralcode: String= "",
    val refreshcontacts: Boolean= false,
    val rejectreason: String= "",
    val response: Response? = null,
    val responsecode: String= "",
    val responsemessage: String= "",
    val upgradestatus: String= "",
    val uploadpath: String= ""
)

