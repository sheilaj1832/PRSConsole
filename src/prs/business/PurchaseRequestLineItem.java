package prs.business;

public class PurchaseRequestLineItem {
	
	private int id;
	private int purchaseRequestId;
	private int productId;
	private int quantity;

	public PurchaseRequestLineItem(int id, int purchaseRequestId, int productId, int quantity) {
		super();
		this.id = id;
		this.purchaseRequestId = purchaseRequestId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPurchaseRequestId() {
		return purchaseRequestId;
	}

	public void setPurchaseRequestId(int purchaseRequestId) {
		this.purchaseRequestId = purchaseRequestId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "PurchaseRequestLineItem [id=" + id + ", purchaseRequestId=" + purchaseRequestId + ", productId="
				+ productId + ", quantity=" + quantity + "]";
	}
	
}
