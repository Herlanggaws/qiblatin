package org.xerv.qiblatin.domain.models

import org.xerv.qiblatin.data.response.PrayerTimingsResponse

data class PrayerTimings(
    val fajr: String,
    val sunrise: String,
    val dhuhr: String,
    val asr: String,
    val sunset: String,
    val maghrib: String,
    val isha: String,
    val imsak: String,
    val midnight: String,
    val firstthird: String,
    val lastthird: String
) {
    constructor(data: PrayerTimingsResponse?) : this(
        fajr = data?.fajr.orEmpty(),
        sunrise = data?.sunrise.orEmpty(),
        dhuhr = data?.dhuhr.orEmpty(),
        asr = data?.asr.orEmpty(),
        sunset = data?.sunset.orEmpty(),
        maghrib = data?.maghrib.orEmpty(),
        isha = data?.isha.orEmpty(),
        imsak = data?.imsak.orEmpty(),
        midnight = data?.midnight.orEmpty(),
        firstthird = data?.firstthird.orEmpty(),
        lastthird = data?.lastthird.orEmpty(),
    )
}
