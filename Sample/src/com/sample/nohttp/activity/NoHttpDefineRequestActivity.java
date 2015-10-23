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
package com.sample.nohttp.activity;

import org.json.JSONObject;

import com.sample.nohttp.R;
import com.sample.nohttp.nohttp.CallServer;
import com.sample.nohttp.nohttp.JsonRequest;
import com.yolanda.nohttp.OnResponseListener;
import com.yolanda.nohttp.Request;
import com.yolanda.nohttp.Response;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * 自定义请求对象
 * Created in Oct 23, 2015 8:12:22 PM
 * 
 * @author YOLANDA
 */
public class NoHttpDefineRequestActivity extends Activity implements OnResponseListener<JSONObject> {

	private TextView mTvStatus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nohttp_define);
		mTvStatus = (TextView) findViewById(R.id.tv_status);
		findViewById(R.id.btn_reqeust_define).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 这里只是为了演示可以自定义请求对象，所以这个地址是模拟的，返回的数据也是模拟的: JsonRequest
				Request<JSONObject> request = new JsonRequest("http://www.baidu.com");
				CallServer.getInstance().add(0, request, NoHttpDefineRequestActivity.this);
			}
		});
	}

	@Override
	public void onStart(int what) {
		mTvStatus.setText("开始了");
	}

	@Override
	public void onSucceed(int what, Response<JSONObject> response) {
		mTvStatus.setText("成功：" + response.get().toString());
	}

	@Override
	public void onFailed(int what, String url, Object tag, CharSequence message) {
		mTvStatus.setText("失败：" + message);
	}

	@Override
	public void onFinish(int what) {
	}

}
