const {test, expect} = require('@playwright/test');

test('Saldo page should load', async ({page}) => {
    await page.goto('http://localhost:8080/balance');
    await expect(page.locator('h1')).toHaveText('Ditt Saldo');
});

test('Saldo should start at 0', async ({page}) => {
    await page.goto('http://localhost:8080/balance');
    const saldoText = await page.locator('span#balance').textContent();
    expect(saldoText).toBe('0');
});

test('Insättning uppdates balance', async ({page}) => {
    await page.goto("http://localhost:8080/balance");

    //klicka på insättning och fyll i 10
    await page.fill('#deposit-input', '10');
    await page.fill('#deposit-button');

    const saldoText = await page.locator('span#balance').textContent();
    expect(saldoText).toBe('10');

})