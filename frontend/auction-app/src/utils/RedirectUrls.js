export const home = "/";

export const loginUrl = "/login";
export const registerUrl = "/register";
export const myAccountUrl = "/my_account";
export const forgotPasswordUrl = "/forgot_password";

export const allCategoryUrl = "/all";

export const shopUrl = "/shop";
export const about = "/shop/about";
export const terms = "/shop/terms";
export const privacy = "/shop/privacy";


export const productUrl = (product) => {
    return `/shop/${formatLink(product.category.name)}/${formatLink(product.subcategory.name)}/${product.id}`;
}

export const categoryUrl = (category) => {
    return `/shop/${formatLink(category.name)}`;
}

export const subcategoryUrl = (subcategory) => {
    return `/shop/${formatLink(subcategory.category.name)}/${(subcategory.name)}`;
}

export const formatLink = (name) => name.split(' ').join('_').toLowerCase();