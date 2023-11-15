package com.recepgemalmaz.pazarama_bootcamp_ders_7_1_dependency_injection_hilt_sample

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

interface ISample {

    fun Foo():String
}

class CSample1 : ISample {
    override fun Foo(): String {
        return "CSample1::Foo"
    }
}
class CSample2 : ISample {
    override fun Foo(): String {
        return "CSample2::Foo"
    }
}
class CSample3 : ISample {
    override fun Foo(): String {
        return "CSample3::Foo"
    }
}

////// Annotation Siniflar //////
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ASample1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ASample2

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ASample3


@InstallIn(SingletonComponent::class)
@Module
class ProviderModule
{
    @Singleton
    @Provides
    @ASample1
    fun ProvideFunc1():ISample
    {
        return CSample1()

    }


    @Provides
    @ASample2
    fun ProvideFunc2():ISample
    {
        return CSample2()

    }

    @Provides
    @ASample3
    fun ProvideFunc3():ISample
    {
        return CSample3()

    }
}



class  CConsumer constructor(private var sample: ISample) {
    fun Test():String {
        return sample.Foo()
    }
}