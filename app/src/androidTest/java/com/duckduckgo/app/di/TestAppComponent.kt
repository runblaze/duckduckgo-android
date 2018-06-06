/*
 * Copyright (c) 2018 DuckDuckGo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duckduckgo.app.di

import android.app.Application
import com.duckduckgo.app.TestApplication
import com.duckduckgo.app.browser.autoComplete.BrowserAutoCompleteModule
import com.duckduckgo.app.browser.di.BrowserModule
import com.duckduckgo.app.browser.di.DefaultBrowserModule
import com.duckduckgo.app.httpsupgrade.di.HttpsUpgraderModule
import com.duckduckgo.app.onboarding.di.OnboardingModule
import com.duckduckgo.app.surrogates.di.ResourceSurrogateModule
import com.duckduckgo.app.trackerdetection.di.TrackerDetectionModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [

    /* test doubled modules */
    StubDatabaseModule::class,
    StubJobSchedulerModule::class,
    StubAppConfigurationDownloadModule::class,
    StubStatisticsModule::class,

    /* real modules */
    ApplicationModule::class,
    AndroidBindingModule::class,
    AndroidSupportInjectionModule::class,
    NetworkModule::class,
    StoreModule::class,
    JsonModule::class,
    BrowserModule::class,
    BrowserAutoCompleteModule::class,
    HttpsUpgraderModule::class,
    ResourceSurrogateModule::class,
    TrackerDetectionModule::class,
    NotificationModule::class,
    DefaultBrowserModule::class,
    OnboardingModule::class,
    VariantModule::class
])
interface TestAppComponent : AndroidInjector<TestApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TestApplication>() {

        @BindsInstance
        abstract fun application(application: Application): TestAppComponent.Builder
    }
}