package it.subito.test.punkapi.beerslist.uimodel

data class UiInfoHolder(val showFiltered: Boolean = false, val page: Int = 1, val brewedAfter: String? = null, val brewedBefore: String? = null)