package it.iquii.test.reddit.domain.repository.database

import it.iquii.test.reddit.di.LocalDataStore
import it.iquii.test.reddit.domain.repository.DataStore
import javax.inject.Inject


class LocalDataStore @Inject constructor() : DataStore