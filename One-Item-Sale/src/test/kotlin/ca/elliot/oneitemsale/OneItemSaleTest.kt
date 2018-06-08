package ca.elliot.oneitemsale

import ca.elliot.oneitemsale.controller.SaleController
import ca.elliot.oneitemsale.handler.IDisplayHandler
import ca.elliot.oneitemsale.handler.impl.DisplayHandlerImpl
import ca.elliot.oneitemsale.infrastructure.impl.DisplayConnectorImpl
import ca.elliot.oneitemsale.infrastructure.IDisplayConnector
import ca.elliot.oneitemsale.manager.IBarcodeManager
import ca.elliot.oneitemsale.manager.IProductManager
import ca.elliot.oneitemsale.manager.impl.BarcodeManagerImpl
import ca.elliot.oneitemsale.manager.impl.ProductManagerImpl
import ca.elliot.oneitemsale.service.ISaleService
import ca.elliot.oneitemsale.service.impl.SaleServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.*
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext
import org.koin.standalone.StandAloneContext.closeKoin
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import org.koin.test.KoinTest
import java.math.BigDecimal

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OneItemSaleTest: KoinTest {

    private val saleController : SaleController by inject()
    private val displayHandler : IDisplayHandler by inject()

    private val module : Module = applicationContext {
        bean { SaleController(get()) }
        bean { BarcodeManagerImpl() as IBarcodeManager }
        bean { SaleServiceImpl(get(), get(), get()) as ISaleService }
        bean { ProductManagerImpl(hashMapOf("32412345" to BigDecimal(8.25), "12345678" to BigDecimal("7.25"))) as IProductManager }
        bean { DisplayConnectorImpl(get()) as IDisplayConnector }
        bean { DisplayHandlerImpl() as IDisplayHandler }
    }

    @BeforeAll
    fun before(){
        startKoin(listOf(module))
    }

    @AfterAll
    fun after(){
        closeKoin()
    }

    @Test
    internal fun `valid barcode received`() {
        saleController.scan("12345678")
        Assertions.assertThat(displayHandler.getDisplayedText()).isEqualTo("7.25$")
    }

    @Test
    internal fun `second valid barcode received`() {
        saleController.scan("32412345")
        Assertions.assertThat(displayHandler.getDisplayedText()).isEqualTo("8.25$")
    }

    @Test
    internal fun `valid barcode product not found`() {
        val barcode = "55555555"
        saleController.scan(barcode)
        Assertions.assertThat(displayHandler.getDisplayedText()).isEqualTo("Product number: $barcode not found")
    }

    @Test
    internal fun `empty bar code`() {
        saleController.scan("")
        Assertions.assertThat(displayHandler.getDisplayedText()).isEqualTo("Invalid barcode: Empty")
    }

    @Test
    internal fun `invalid barcode with letters`() {
        val barcode = "ASBFSDDF"
        saleController.scan(barcode)
        Assertions.assertThat(displayHandler.getDisplayedText()).isEqualTo("Invalid barcode: $barcode")
    }
}


