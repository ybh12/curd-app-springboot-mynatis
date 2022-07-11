package com.travel.form.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.travel.form.costants.DbConstants;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author by 李泽阳 on 2022/6/12 19:11
 * @description：
 */
@Component
@ConditionalOnClass(MetaObjectHandler.class)
public class MetaObjectHandlerConfig implements MetaObjectHandler{
    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasSetter(DbConstants.DB_FIELD_RECORD_VERSION) &&
                getFieldValByName(DbConstants.DB_FIELD_RECORD_VERSION, metaObject) == null) {
            setFieldValByName(DbConstants.DB_FIELD_RECORD_VERSION, 1, metaObject);
        }

        if (metaObject.hasSetter(DbConstants.DB_FIELD_CREATED_BY) &&
                getFieldValByName(DbConstants.DB_FIELD_CREATED_BY, metaObject) == null) {
            setFieldValByName(DbConstants.DB_FIELD_CREATED_BY, "-1", metaObject);
        }

        if (metaObject.hasSetter(DbConstants.DB_FIELD_CREATED_TIME) &&
                getFieldValByName(DbConstants.DB_FIELD_CREATED_TIME, metaObject) == null) {
            setFieldValByName(DbConstants.DB_FIELD_CREATED_TIME, LocalDateTime.now(), metaObject);
        }

        if (metaObject.hasSetter(DbConstants.DB_FIELD_DEL_FLAG) &&
                getFieldValByName(DbConstants.DB_FIELD_DEL_FLAG, metaObject) == null) {
            setFieldValByName(DbConstants.DB_FIELD_DEL_FLAG, 0, metaObject);
        }

        if (metaObject.hasSetter(DbConstants.DB_FIELD_UPDATED_BY) &&
                getFieldValByName(DbConstants.DB_FIELD_UPDATED_BY, metaObject) == null) {
            setFieldValByName(DbConstants.DB_FIELD_UPDATED_BY, "-1", metaObject);
        }

        if (metaObject.hasSetter(DbConstants.DB_FIELD_UPDATED_TIME)) {
            setFieldValByName(DbConstants.DB_FIELD_UPDATED_TIME, LocalDateTime.now(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasSetter(DbConstants.DB_FIELD_UPDATED_BY) &&
                getFieldValByName(DbConstants.DB_FIELD_UPDATED_BY, metaObject) == null) {
            setFieldValByName(DbConstants.DB_FIELD_UPDATED_BY, "-1", metaObject);
        }

        if (metaObject.hasSetter(DbConstants.DB_FIELD_UPDATED_TIME)) {
            setFieldValByName(DbConstants.DB_FIELD_UPDATED_TIME, LocalDateTime.now(), metaObject);
        }
    }
}
