package org.xerv.qiblatin.domain.models

import org.xerv.qiblatin.data.response.PrayerDataResponse

data class PrayerData(
    val timings: PrayerTimings,
    val date: DateInfo
) {
    constructor(data: PrayerDataResponse?) : this(
        timings = PrayerTimings(data?.timings),
        date = DateInfo(data?.date)
    )
}
