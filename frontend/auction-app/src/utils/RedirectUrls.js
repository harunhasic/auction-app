export const home = "/";

export const loginUrl = "/login";
export const registerUrl = "/register";
export const myAccountUrl = "/my_account";
export const allCategoryUrl = "/categories";

export const shopUrl = "/shop";
export const about = "/about";
export const terms = "/terms";
export const privacy = "/privacy";


export function productUrl(product, category) {
    return `/shop/${encodeURI(category.name)}/${encodeURI(product.subcategory.name)}/${product.id}`;
}

export function categoryUrl(category) {
    return `/shop/${encodeURI(category.name)}`;
}

export function subcategoryUrl(subcategory) {
    return `/shop/${subcategory.category.name}/${encodeURI(subcategory.name)}`;
}

