package com.alienlab.university.config;

import io.github.jhipster.config.JHipsterProperties;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.ehcache.jsr107.Eh107Configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
@AutoConfigureAfter(value = { MetricsConfiguration.class })
@AutoConfigureBefore(value = { WebConfigurer.class, DatabaseConfiguration.class })
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        JHipsterProperties.Cache.Ehcache ehcache =
            jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(ehcache.getTimeToLiveSeconds(), TimeUnit.SECONDS)))
                .build());
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache(com.alienlab.university.domain.User.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.Authority.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.User.class.getName() + ".authorities", jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.BaseTerm.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.BaseDepartment.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.BaseTeacher.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.BaseMajor.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.BaseCourse.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.CourseVersion.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.CourseGroup.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.CourseGroupItem.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.CourseTree.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.BaseMajorCourse.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.BaseClasses.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.BaseTeachTask.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.BaseResourceType.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.BaseResource.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.TeacherResource.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.CourseResource.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.CourseStruct.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.CourseStruct.class.getName() + ".resources", jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.CourseOnClass.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.CourseTalk.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.ResourceComment.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.TeacherComment.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.MajorTraning.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.TraningStruct.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.TraningStructRelation.class.getName(), jcacheConfiguration);
            cm.createCache(com.alienlab.university.domain.TraningData.class.getName(), jcacheConfiguration);
            // jhipster-needle-ehcache-add-entry
        };
    }
}
