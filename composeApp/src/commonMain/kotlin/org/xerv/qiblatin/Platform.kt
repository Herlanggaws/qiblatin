package org.xerv.qiblatin

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform