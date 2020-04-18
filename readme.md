  redis:
    cluster:
      nodes:
        - cnedtechstgrediscluster-1.nsmena.clustercfg.cnn1.cache.amazonaws.com.cn:6379
    database: 0
    lettuce:
      pool:
        max-active: 10000
        max-wait: 5000ms
        max-idle: 30
        min-idle: 5
    timeout: 5000ms
    app-enabled: true
    app-ttl: 1d
    app-prefix: test