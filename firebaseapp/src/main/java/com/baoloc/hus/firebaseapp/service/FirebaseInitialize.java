package com.baoloc.hus.firebaseapp.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInitialize
{
	@PostConstruct
	public void init() throws IOException
	{
		InetSocketAddress address = new InetSocketAddress("10.225.3.1", 3128);
		final HttpTransport transport = new NetHttpTransport.Builder().setProxy(new Proxy(Proxy.Type.HTTP, address))
				.build();
		HttpTransportFactory transportFactory = new HttpTransportFactory()
		{
			@Override
			public HttpTransport create()
			{
				return transport;
			}
		};
		FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount, transportFactory))
				.setHttpTransport(transport).setDatabaseUrl("https://spring-firebase-app.firebaseio.com")
				.setConnectTimeout(2 * 1000).setReadTimeout(3 * 1000).build();
		FirebaseApp.initializeApp(options);
	}
}
