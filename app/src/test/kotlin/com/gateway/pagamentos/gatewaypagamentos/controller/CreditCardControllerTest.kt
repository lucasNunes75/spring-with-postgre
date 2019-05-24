package com.gateway.pagamentos.gatewaypagamentos.controller

import com.gateway.pagamentos.gateway.controller.CreditCardController
import org.json.JSONObject
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders


@RunWith(SpringRunner::class)
class CreditCardControllerTest {

    private var mockMvc: MockMvc? = null

    @Autowired
    private val creditCardController: CreditCardController? = CreditCardController()


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(creditCardController).build()
    }

    @Test
    @Throws(Exception::class)
    fun findOneTest() {
        this.mockMvc!!.perform(MockMvcRequestBuilders.get("/credit_card/1"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    }

    @Test
    @Throws(Exception::class)
    fun addCreditSuccess() {
        val credit = mapOf(
            "clientId" to 1,
            "statementDescriptor" to "JOSE SILVA",
            "number" to "1234567890987",
            "holderName" to "JOSE SILVA",
            "holderDocument" to "10188607030",
            "expirationDate" to "0420",
            "cvv" to "187"
        )

        this.mockMvc!!.perform(
            MockMvcRequestBuilders.post("/credit_card")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject(credit).toString())
        )
            .andExpect(status().isCreated)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    }
}