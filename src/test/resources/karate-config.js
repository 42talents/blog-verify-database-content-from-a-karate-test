function fn() {
    var env = karate.env; // get java system property 'karate.env'
    karate.log('karate.env system property was:', env);
    if (!env) {
        env = 'dev'; // a custom 'intelligent' default
        karate.log('karate.env set to "dev" as default.');
    }
    let config;
    if (env === 'dev') {
        let postgresConfig = {
            url: karate.properties['postgres.url'] || "jdbc:postgresql://localhost:5432/",
            username: karate.properties['postgres.username'] || "postgres",
            password: karate.properties['postgres.password'] || "test",
            driver: karate.properties['postgres.driver'] || "org.postgresql.Driver",
        }
        let port = karate.properties['karate.port'] || '8080'
        config = {
            baseUrl: 'http://localhost:' + port,
            postgresConfig: postgresConfig
        }
    } else {
        throw 'Unknown environment [' + env + '].'
    }
    // don't waste time waiting for a connection or if servers don't respond within 0,3 seconds
    karate.configure('connectTimeout', 300);
    karate.configure('readTimeout', 300);
    return config;
}