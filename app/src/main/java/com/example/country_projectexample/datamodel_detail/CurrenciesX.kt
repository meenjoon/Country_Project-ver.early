//package com.example.country_projectexample.data_example
//
//
//import com.google.gson.annotations.SerializedName
//
//data class CurrenciesX(
//    @SerializedName("AED")
//    val aED: AED?,
//    @SerializedName("AFN")
//    val aFN: AFN?,
//    @SerializedName("ALL")
//    val aLL: ALL?,
//    @SerializedName("ANG")
//    val aNG: ANG?,
//    @SerializedName("AOA")
//    val aOA: AOA?,
//    @SerializedName("ARS")
//    val aRS: ARS?,
//    @SerializedName("AUD")
//    val aUD: AUD?,
//    @SerializedName("AZN")
//    val aZN: AZN?,
//    @SerializedName("BAM")
//    val bAM: BAM?,
//    @SerializedName("BBD")
//    val bBD: BBD?,
//    @SerializedName("BDT")
//    val bDT: BDT?,
//    @SerializedName("BGN")
//    val bGN: BGN?,
//    @SerializedName("BHD")
//    val bHD: BHD?,
//    @SerializedName("BND")
//    val bND: BND?,
//    @SerializedName("BOB")
//    val bOB: BOB?,
//    @SerializedName("BRL")
//    val bRL: BRL?,
//    @SerializedName("BSD")
//    val bSD: BSD?,
//    @SerializedName("BTN")
//    val bTN: BTN?,
//    @SerializedName("BWP")
//    val bWP: BWP?,
//    @SerializedName("BYN")
//    val bYN: BYN?,
//    @SerializedName("CAD")
//    val cAD: CAD?,
//    @SerializedName("CDF")
//    val cDF: CDF?,
//    @SerializedName("CHF")
//    val cHF: CHF?,
//    @SerializedName("CKD")
//    val cKD: CKD?,
//    @SerializedName("CLP")
//    val cLP: CLP?,
//    @SerializedName("CNY")
//    val cNY: CNY?,
//    @SerializedName("COP")
//    val cOP: COP?,
//    @SerializedName("CRC")
//    val cRC: CRC?,
//    @SerializedName("CUC")
//    val cUC: CUC?,
//    @SerializedName("CUP")
//    val cUP: CUP?,
//    @SerializedName("CVE")
//    val cVE: CVE?,
//    @SerializedName("CZK")
//    val cZK: CZK?,
//    @SerializedName("DJF")
//    val dJF: DJF?,
//    @SerializedName("DKK")
//    val dKK: DKK?,
//    @SerializedName("DOP")
//    val dOP: DOP?,
//    @SerializedName("DZD")
//    val dZD: DZD?,
//    @SerializedName("ETB")
//    val eTB: ETB?,
//    @SerializedName("FJD")
//    val fJD: FJD?,
//    @SerializedName("FKP")
//    val fKP: FKP?,
//    @SerializedName("FOK")
//    val fOK: FOK?,
//    @SerializedName("GBP")
//    val gBP: GBP?,
//    @SerializedName("GEL")
//    val gEL: GEL?,
//    @SerializedName("GMD")
//    val gMD: GMD?,
//    @SerializedName("GNF")
//    val gNF: GNF?,
//    @SerializedName("GTQ")
//    val gTQ: GTQ?,
//    @SerializedName("GYD")
//    val gYD: GYD?,
//    @SerializedName("HKD")
//    val hKD: HKD?,
//    @SerializedName("HNL")
//    val hNL: HNL?,
//    @SerializedName("HTG")
//    val hTG: HTG?,
//    @SerializedName("HUF")
//    val hUF: HUF?,
//    @SerializedName("IDR")
//    val iDR: IDR?,
//    @SerializedName("ILS")
//    val iLS: ILS?,
//    @SerializedName("INR")
//    val iNR: INR?,
//    @SerializedName("IQD")
//    val iQD: IQD?,
//    @SerializedName("IRR")
//    val iRR: IRR?,
//    @SerializedName("ISK")
//    val iSK: ISK?,
//    @SerializedName("JEP")
//    val jEP: JEP?,
//    @SerializedName("JMD")
//    val jMD: JMD?,
//    @SerializedName("JPY")
//    val jPY: JPY?,
//    @SerializedName("KES")
//    val kES: KES?,
//    @SerializedName("KGS")
//    val kGS: KGS?,
//    @SerializedName("KHR")
//    val kHR: KHR?,
//    @SerializedName("KPW")
//    val kPW: KPW?,
//    @SerializedName("KRW")
//    val kRW: KRW?,
//    @SerializedName("KWD")
//    val kWD: KWD?,
//    @SerializedName("KYD")
//    val kYD: KYD?,
//    @SerializedName("LAK")
//    val lAK: LAK?,
//    @SerializedName("LBP")
//    val lBP: LBP?,
//    @SerializedName("LKR")
//    val lKR: LKR?,
//    @SerializedName("LRD")
//    val lRD: LRD?,
//    @SerializedName("LSL")
//    val lSL: LSL?,
//    @SerializedName("LYD")
//    val lYD: LYD?,
//    @SerializedName("MAD")
//    val mAD: MADX?,
//    @SerializedName("MKD")
//    val mKD: MKD?,
//    @SerializedName("MMK")
//    val mMK: MMK?,
//    @SerializedName("MNT")
//    val mNT: MNT?,
//    @SerializedName("MOP")
//    val mOP: MOP?,
//    @SerializedName("MUR")
//    val mUR: MUR?,
//    @SerializedName("MVR")
//    val mVR: MVR?,
//    @SerializedName("MWK")
//    val mWK: MWK?,
//    @SerializedName("MXN")
//    val mXN: MXN?,
//    @SerializedName("MYR")
//    val mYR: MYR?,
//    @SerializedName("MZN")
//    val mZN: MZN?,
//    @SerializedName("NAD")
//    val nAD: NAD?,
//    @SerializedName("NIO")
//    val nIO: NIO?,
//    @SerializedName("NOK")
//    val nOK: NOK?,
//    @SerializedName("NZD")
//    val nZD: NZD?,
//    @SerializedName("OMR")
//    val oMR: OMR?,
//    @SerializedName("PAB")
//    val pAB: PAB?,
//    @SerializedName("PEN")
//    val pEN: PEN?,
//    @SerializedName("PGK")
//    val pGK: PGK?,
//    @SerializedName("PKR")
//    val pKR: PKR?,
//    @SerializedName("PLN")
//    val pLN: PLN?,
//    @SerializedName("PYG")
//    val pYG: PYG?,
//    @SerializedName("QAR")
//    val qAR: QAR?,
//    @SerializedName("RON")
//    val rON: RON?,
//    @SerializedName("RSD")
//    val rSD: RSD?,
//    @SerializedName("RUB")
//    val rUB: RUB?,
//    @SerializedName("RWF")
//    val rWF: RWF?,
//    @SerializedName("SAR")
//    val sAR: SAR?,
//    @SerializedName("SBD")
//    val sBD: SBD?,
//    @SerializedName("SDG")
//    val sDG: SDG?,
//    @SerializedName("SEK")
//    val sEK: SEK?,
//    @SerializedName("SGD")
//    val sGD: SGD?,
//    @SerializedName("SHP")
//    val sHP: SHP?,
//    @SerializedName("SLL")
//    val sLL: SLL?,
//    @SerializedName("SOS")
//    val sOS: SOS?,
//    @SerializedName("SRD")
//    val sRD: SRD?,
//    @SerializedName("SSP")
//    val sSP: SSP?,
//    @SerializedName("STN")
//    val sTN: STN?,
//    @SerializedName("SYP")
//    val sYP: SYP?,
//    @SerializedName("SZL")
//    val sZL: SZL?,
//    @SerializedName("THB")
//    val tHB: THB?,
//    @SerializedName("TMT")
//    val tMT: TMT?,
//    @SerializedName("TND")
//    val tND: TND?,
//    @SerializedName("TRY")
//    val tRY: TRY?,
//    @SerializedName("TTD")
//    val tTD: TTD?,
//    @SerializedName("TWD")
//    val tWD: TWD?,
//    @SerializedName("TZS")
//    val tZS: TZS?,
//    @SerializedName("UGX")
//    val uGX: UGX?,
//    @SerializedName("UYU")
//    val uYU: UYU?,
//    @SerializedName("UZS")
//    val uZS: UZS?,
//    @SerializedName("VUV")
//    val vUV: VUV?,
//    @SerializedName("XAF")
//    val xAF: XAF?,
//    @SerializedName("XCD")
//    val xCD: XCD?,
//    @SerializedName("XOF")
//    val xOF: XOF?,
//    @SerializedName("XPF")
//    val xPF: XPF?,
//    @SerializedName("YER")
//    val yER: YER?,
//    @SerializedName("ZAR")
//    val zAR: ZAR?,
//    @SerializedName("ZMW")
//    val zMW: ZMW?,
//    @SerializedName("ZWL")
//    val zWL: ZWL?
//)
