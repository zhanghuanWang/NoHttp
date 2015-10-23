/*
 * Copyright © YOLANDA. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yolanda.nohttp.download;

/**
 * The download process monitor</br>
 * Created in Jul 31, 2015 9:12:55 AM
 * 
 * @author YOLANDA
 */
public interface DownloadListener {

	/**
	 * An error occurred while downloading
	 * 
	 * @param what Which is used to mark the download tasks
	 * @param statusCode Error code, used to distinguish what kind of mistake
	 * @param errorMessage error message
	 */
	public abstract void onDownloadError(int what, StatusCode statusCode, CharSequence errorMessage);

	/**
	 * When this download task starts the callback method
	 * 
	 * @param what Which is used to mark the download tasks
	 */
	public abstract void onStart(int what);

	/**
	 * When the download process change
	 * 
	 * @param what Which is used to mark the download tasks
	 * @param progress This method is the time to change the progress of the download.
	 */
	public abstract void onProgress(int what, int progress);

	/**
	 * Download is complete.
	 * 
	 * @param what Which is used to mark the download tasks.
	 * @param filePath Where is the file after the download is complete.
	 */
	public abstract void onFinish(int what, String filePath);

	/**
	 * Download request is canceled
	 * 
	 * @param what Which is used to mark the download tasks
	 */
	public abstract void onCancel(int what);
}