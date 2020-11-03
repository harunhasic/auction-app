export const home = "/";

export const loginUrl = "/login";
export const registerUrl = "/register";
export const myAccountUrl = "/my_account";
export const allCategoryUrl = "/categories";

export const shopUrl = "/shop";
export const about = "/shop/about";
export const terms = "/shop/terms";
export const privacy = "/shop/privacy";


export function productUrl(product, category) {
    return `/${encodeURI(category.name)}/${encodeURI(product.subcategory.name)}/${product.id}`;
}

export function categoryUrl(category) {
    return `/${encodeURI(category.name)}`;
}

export function subcategoryUrl(subcategory) {
    return `/${(subcategory.name)}`;
}

