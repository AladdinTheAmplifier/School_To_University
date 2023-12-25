package com.s2u.admissionregistryservice.config;

import com.s2u.admissionregistryservice.entity.AuditModel;

public interface Auditable {

	AuditModel getAudit();

	void setAudit(AuditModel audit);

}
