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

export const formatLink = (name) => name.split(' ').join('_').toLowerCase();

export const productUrl = (product) => {
    return `/${formatLink(product.category.name)}/${formatLink(product.subcategory.name)}/${product.id}`;
}

export const categoryUrl = (category) => {
    return `/${formatLink(category.name)}`;
}

export const subcategoryUrl = (subcategory) => {
    return `/${formatLink(subcategory.category.name)}/${(subcategory.name)}`;
}

