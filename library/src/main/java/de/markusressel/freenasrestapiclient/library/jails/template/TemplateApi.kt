/*
 * Copyright (c) 2018 Markus Ressel
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

package de.markusressel.freenasrestapiclient.library.jails.template

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.result.Result
import de.markusressel.freenasrestapiclient.library.RequestManager
import de.markusressel.freenasrestapiclient.library.jails.mountpoint.MountpointModel
import io.reactivex.Single

interface TemplateApi {
    /**
     * Get a list of all templates
     */
    fun getTemplates(limit: Int = RequestManager.DEFAULT_LIMIT,
                     offset: Int = RequestManager.DEFAULT_OFFSET): Single<List<TemplateModel>>

    /**
     * Create a new template
     */
    fun createTemplate(jt_arch: String, jt_instances: Long, jt_name: String, jt_os: String,
                       jt_url: String): Single<TemplateModel>

    /**
     * Update an existing template
     */
    fun updateTemplate(id: Long, jt_arch: String, jt_instances: Long, jt_name: String,
                       jt_os: String, jt_url: String): Single<MountpointModel>

    /**
     * Delete a template
     */
    fun deleteTemplate(templateId: Long): Single<Pair<Response, Result<ByteArray, FuelError>>>
}