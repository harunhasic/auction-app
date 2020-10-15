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
    return `/product/${(product.categoryName)}/${(product.subcategoryName)}/${product.id}`;
}

export const categoryUrl = (category) => {
    return `/categories/${(category.name)}`;
}

export const subcategoryUrl = (subcategory) => {
    return `/subcategories/${(subcategory.categoryName)}/${(subcategory.name)}`;
}
