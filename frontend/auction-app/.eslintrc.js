module.exports = {
    "env": {
        "browser": true,
        "es2021": true
    },
    "extends": [
        "eslint:recommended",
        "plugin:react/recommended"
    ],
    "parserOptions": {
        "ecmaFeatures": {
            "jsx": true
        },
        "ecmaVersion": 12,
        "sourceType": "module"
    },
    "plugins": [
        "react"
    ],
    "rules": {
        'react/prefer-es6-class': ['warn', 'always'],
		'react/jsx-filename-extension': [1, {
			'extensions': ['.jsx']
		}],
		'react/jsx-pascal-case': [2, {
			'allowAllCaps': false,
		}],
		'react/jsx-closing-bracket-location': ['warn', 'tag-aligned'],
		'react/jsx-curly-spacing': ['warn', {
			'when': 'never'
		}],
		'react/jsx-closing-tag-location': 'warn',
		'react/jsx-boolean-value': ['warn', 'always'],
		'react/jsx-key': 'warn',
		'react/no-string-refs': 'warn',
		'react/jsx-wrap-multilines': 'warn',
		'react/self-closing-comp': 'warn',
		'react/prop-types': 'warn',
		'react/jsx-no-bind': 'warn',
		'react/require-render-return': 'warn',
		'react/jsx-tag-spacing': 'warn',
		'no-multi-spaces': 'warn',
		'indent': ['warn', 2],
		'linebreak-style': ['error', 'unix'],
		'jsx-quotes': ['warn', 'prefer-double'],
		'max-lines': ['warn', 300],
		'max-len': ['warn', {
			'code': 120
		}],
		'quotes': ['warn', 'single'],
		'semi': ['error', 'always'],
		'no-console': ['warn', {
			'allow': ['error']
		}],
		'no-trailing-spaces': 'warn',
		'no-unused-vars': 'warn'
    }
};
