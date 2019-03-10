/*
 * Copyright (c) 2019 Markus Ressel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons
 * to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.markusressel.freenasrestapiclient.api.v2

import android.util.Log
import de.markusressel.freenasrestapiclient.core.BasicAuthConfig
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass

abstract class TestBase : WebsocketConnectionListener {

    val underTest: FreeNasRestApiV2Client = FreeNasRestApiV2Client(
            baseUrl = "wss://frittenbude.markusressel.de/websocket",
            auth = BasicAuthConfig(
                    username = "root",
                    password = "bZ_EL80yL9mj=m&amp;9WB32eKPDo")
    )

    @Before
    open fun before() {
        runBlocking {
            val result = underTest.connect()
            result.fold(success = {
                // ok
            }, failure = {
                throw  it
            })
        }

        Log.d("", "")
    }

    @After
    open fun after() {
        runBlocking {
            val result = underTest.disconnect()
            result.fold(success = {
                // ok
            }, failure = {
                throw  it
            })
        }
    }


    companion object {
        @BeforeClass
        fun beforeClass() {
        }

        @AfterClass
        fun afterClass() {

        }
    }

}