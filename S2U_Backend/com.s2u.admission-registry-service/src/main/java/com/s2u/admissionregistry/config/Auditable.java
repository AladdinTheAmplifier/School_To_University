package com.s2u.admissionregistry.config;

import com.s2u.admissionregistry.entity.AuditModel;

public interface Auditable {

	AuditModel getAudit();

	void setAudit(AuditModel audit);

}
