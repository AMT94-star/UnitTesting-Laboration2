const {test, expect} = require('@playwright/test');

test('Saldo page should load', async ({page}) => {
    await page.goto('http://localhost:8080/balance');
    await expect(page.locator('h1')).toHaveText('Ditt Saldo');
});