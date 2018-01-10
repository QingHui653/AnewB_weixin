package com.jfinal.weixin.plugin;

import com.jfinal.ext.plugin.monogodb.MongoKit;
import com.jfinal.ext.plugin.monogodb.MongodbPlugin;
import com.jfinal.plugin.IPlugin;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class AuthMongodbPlugin implements IPlugin {
    private static final String DEFAULT_HOST = "127.0.0.1";
    private static final int DEFAUL_PORT = 27017;

    private MongoClient client;
    private String host;
    private int port;
    private String user;
    private String password;
    private String database;

    public AuthMongodbPlugin(String database) {
        this.host = DEFAULT_HOST;
        this.port = DEFAUL_PORT;
        this.database = database;
    }

    public AuthMongodbPlugin(String host, int port, String database) {
        this.host = host;
        this.port = port;
        this.database = database;
    }

    public AuthMongodbPlugin(String host, int port, String user, String password, String database) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.database = database;
    }

    @Override
    public boolean start() {
        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential credential = MongoCredential.createScramSha1Credential(user, database, password.toCharArray());
        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(credential);
        client = new MongoClient(new ServerAddress(host, port),credentials);
        MongoKit.init(client, database);
        return true;
    }

    @Override
    public boolean stop() {
        if (client != null) {
            client.close();
        }
        return true;
    }
}
