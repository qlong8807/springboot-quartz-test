#说明
>项目使用的是SpringBoot-2.0.3，该版本自带quartz.1.*.*版本没有自带quartz，需手动引入。

本项目实现
* 监听SpringBoot项目启动完成
* Spring自带定时任务调度器
* quartz定时任务调度器(未持久化到数据库，每次启动项目后需触发执行)
>如果是SpringBoot 1.*.*则需要config配置。
 如果是SpringBoot 2（默认自动配置）则不需要config配置，如果有特殊配置则需要config配置或在配置文件配置。