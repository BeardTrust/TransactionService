package com.beardtrust.webapp.transactionservice.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "loans")
public class LoanEntity extends FinancialAsset {
	private static final long serialVersionUID = -7188429291280586507L;

	@ManyToOne
	private LoanTypeEntity loanType;
	@SuppressWarnings({"JpaModelReferenceInspection", "JpaDataSourceORMInspection"})
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "cents", column = @Column(name = "principalCents")),
			@AttributeOverride(name = "dollars", column = @Column(name = "principalDollars")),
			@AttributeOverride(name = "isNegative", column = @Column(name = "principalIsNegative"))
	})
	private CurrencyValue principal;
	@OneToOne
	private PaymentEntity payment;

	public LoanEntity() {
		super();
		this.setCreateDate(LocalDateTime.now());
		this.setId(UUID.randomUUID().toString());
		this.setBalance(new CurrencyValue());
	}

	public LoanTypeEntity getLoanType() {
		return loanType;
	}

	public void setLoanType(LoanTypeEntity loanType) {
		this.loanType = loanType;
	}

	public CurrencyValue getPrincipal() {
		return principal;
	}

	public void setPrincipal(CurrencyValue principal) {
		this.principal = principal;
	}

	public PaymentEntity getPayment() {
		return payment;
	}

	public void setPayment(PaymentEntity payment) {
		this.payment = payment;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LoanEntity that = (LoanEntity) o;
		return Objects.equals(getLoanType(), that.getLoanType()) && Objects.equals(getPayment(), that.getPayment());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getLoanType(), getPayment());
	}

	@Override
	public String toString() {
		return "LoanEntity{" +
				"loanType=" + loanType +
				", payment=" + payment +
				'}';
	}
}
