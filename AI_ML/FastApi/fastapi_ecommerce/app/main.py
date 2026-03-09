
from fastapi import FastAPI, HTTPException, Query
from service.products import get_all_products


app = FastAPI()


@app.get("/")                    
def root():
    return {"message": "Welcome to the FastAPI E-commerce application!"}


# @app.get("/products")
# def get_products():
#     return get_all_products()

@app.get("/products")
def list_products(
    name: str = Query(
        default=None,
        min_length=1,
        max_length=50,
        description="Filter products by name (case-insensitive)"
        ),
    sort_by_price: bool = Query(
        default=False,
        description="Sort products by price"
        ),
    order: str = Query(
        default="asc",  
        description="Sort order when sort_by_price=true (asc,desc)",
        ),
    ):

    products = get_all_products()
    logger.debug("Loaded %d products", len(products))

    if name:
        needle = name.strip().lower()
        logger.debug("Search needle raw=%r cleaned=%r", name, needle)
        names_preview = [p.get("name", "") for p in products][:12]
        logger.debug("First product names preview: %s", names_preview)

        products = [p for p in products
                    if needle in p.get("name", "").lower()]
        logger.debug("Matched products count for %r: %d", needle, len(products))
        if products:
            logger.debug("Matched sample names: %s", [p.get("name", "") for p in products][:5])

        if not products:
            raise HTTPException(status_code=404, detail=f"No products found matching name={name}.")

    if sort_by_price:
        reverse = order.lower() == "desc"
        products = sorted(products, key=lambda x: x.get("price", 0), reverse=reverse)

    total = len(products)

    return {"total": total, "items": products}