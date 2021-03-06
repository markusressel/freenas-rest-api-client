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

package de.markusressel.freenasrestapiclient.library.storage

import de.markusressel.freenasrestapiclient.library.RequestManager
import de.markusressel.freenasrestapiclient.library.jails.jail.VolumeApi
import de.markusressel.freenasrestapiclient.library.storage.dataset.DatasetApi
import de.markusressel.freenasrestapiclient.library.storage.dataset.DatasetHandler
import de.markusressel.freenasrestapiclient.library.storage.disk.DiskApi
import de.markusressel.freenasrestapiclient.library.storage.disk.DiskHandler
import de.markusressel.freenasrestapiclient.library.storage.scrub.ScrubApi
import de.markusressel.freenasrestapiclient.library.storage.scrub.ScrubHandler
import de.markusressel.freenasrestapiclient.library.storage.snapshot.SnapshotApi
import de.markusressel.freenasrestapiclient.library.storage.snapshot.SnapshotHandler
import de.markusressel.freenasrestapiclient.library.storage.task.TaskApi
import de.markusressel.freenasrestapiclient.library.storage.task.TaskHandler
import de.markusressel.freenasrestapiclient.library.storage.volume.VolumeHandler

/**
 * Created by Markus on 09.02.2018.
 */
class StorageManager(private val requestManager: RequestManager,
                     datasetApi: DatasetApi = DatasetHandler(requestManager),
                     diskApi: DiskApi = DiskHandler(requestManager),
                     scrubApi: ScrubApi = ScrubHandler(requestManager),
                     snapshotApi: SnapshotApi = SnapshotHandler(requestManager),
                     taskApi: TaskApi = TaskHandler(requestManager),
                     volumeApi: VolumeApi = VolumeHandler(requestManager)) :
        DatasetApi by datasetApi, DiskApi by diskApi, ScrubApi by scrubApi, SnapshotApi by snapshotApi,
        TaskApi by taskApi, VolumeApi by volumeApi, StorageApi