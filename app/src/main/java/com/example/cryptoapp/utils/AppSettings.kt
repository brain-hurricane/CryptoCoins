import android.content.Context

class AppSettings(context: Context) {

    private val sharedPreferences = context.getSharedPreferences(
        context.packageName + "_preferences",
        Context.MODE_PRIVATE
    )
    private val editor = sharedPreferences.edit()
    private val key = "currentCurrency"

    fun setCurrency(currency: String) {
//        val currencyStr = when (currency) {
//            Currency.EUR -> "EUR"
//            Currency.RUB -> "RUB"
//            Currency.USD -> "USD"
//        }
        editor.putString(key, currency)
        editor.apply()
    }

    fun getCurrency(): String {
        return sharedPreferences.getString(key, "USD") ?: return "USD"
    }

}