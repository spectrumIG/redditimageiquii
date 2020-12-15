package it.subito.test.punkapi.domain.entity.remote

import it.subito.test.punkapi.domain.entity.remote.BeersListDTO.BeersListDTOItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class BeersListDTO : ArrayList<BeersListDTOItem>() {
    @Serializable
    data class BeersListDTOItem(
        @SerialName("abv")
        val abv: Double?,
        @SerialName("attenuation_level")
        val attenuationLevel: Double?,
        @SerialName("boil_volume")
        val boilVolume: BoilVolume?,
        @SerialName("brewers_tips")
        val brewersTips: String?,
        @SerialName("contributed_by")
        val contributedBy: String?,
        @SerialName("description")
        val description: String?,
        @SerialName("ebc")
        val ebc: Double?,
        @SerialName("first_brewed")
        val firstBrewed: String?,
        @SerialName("food_pairing")
        val foodPairing: List<String?>?,
        @SerialName("ibu")
        val ibu: Double?,
        @SerialName("id")
        val id: Int?,
        @SerialName("image_url")
        val imageUrl: String?,
        @SerialName("ingredients")
        val ingredients: Ingredients?,
        @SerialName("method")
        val method: Method?,
        @SerialName("name")
        val name: String?,
        @SerialName("ph")
        val ph: Double?,
        @SerialName("srm")
        val srm: Double?,
        @SerialName("tagline")
        val tagline: String?,
        @SerialName("target_fg")
        val targetFg: Double?,
        @SerialName("target_og")
        val targetOg: Double?,
        @SerialName("volume")
        val volume: Volume?,
    ) {
        @Serializable
        data class BoilVolume(
            @SerialName("unit")
            val unit: String?,
            @SerialName("value")
            val value: Int?,
        )

        @Serializable
        data class Ingredients(
            @SerialName("hops")
            val hops: List<String?>?,
            @SerialName("malt")
            val malt: List<Malt?>?,
            @SerialName("yeast")
            val yeast: String?,
        ) {
            @Serializable
            data class Malt(
                @SerialName("amount")
                val amount: Amount?,
                @SerialName("name")
                val name: String?,
            ) {
                @Serializable
                data class Amount(
                    @SerialName("unit")
                    val unit: String?,
                    @SerialName("value")
                    val value: Double?,
                )
            }
        }

        @Serializable
        data class Method(
            @SerialName("fermentation")
            val fermentation: Fermentation?,
            @SerialName("mash_temp")
            val mashTemp: List<MashTemp?>?,
            @SerialName("twist")
            val twist: String?,
        ) {
            @Serializable
            data class Fermentation(
                @SerialName("temp")
                val temp: Temp?,
            ) {
                @Serializable
                data class Temp(
                    @SerialName("unit")
                    val unit: String?,
                    @SerialName("value")
                    val value: Double?,
                )
            }

            @Serializable
            data class MashTemp(
                @SerialName("duration")
                val duration: Int?,
                @SerialName("temp")
                val temp: Temp?,
            ) {
                @Serializable
                data class Temp(
                    @SerialName("unit")
                    val unit: String?,
                    @SerialName("value")
                    val value: Int?,
                )
            }
        }

        @Serializable
        data class Volume(
            @SerialName("unit")
            val unit: String?,
            @SerialName("value")
            val value: Int?,
        )
    }
}